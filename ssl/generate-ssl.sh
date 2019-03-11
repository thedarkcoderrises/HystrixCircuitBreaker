#!/usr/bin/env bash

# Set the TLD domain we want to use
BASE_DOMAIN="localhost"

# Days for the cert to live
DAYS=365

# A blank passphrase
PASSPHRASE="changeit"

# Generated configuration file
CONFIG_FILE="config.txt"

cat > $CONFIG_FILE <<-EOF
[req]
default_bits = 2048
prompt = no
default_md = sha256
distinguished_name = dn

[dn]
C = IN
ST = Maharashtra
L = Pune
O = thedarkcoderrises.org
OU = tdcrOrgUnit
emailAddress = thedarkcoderrises@gmail.com
CN = $BASE_DOMAIN
EOF

cat > v3.ext <<-EOF
authorityKeyIdentifier=keyid,issuer
basicConstraints=CA:FALSE
keyUsage = digitalSignature, nonRepudiation, keyEncipherment, dataEncipherment
subjectAltName = @alt_names

[alt_names]
DNS.1 = $BASE_DOMAIN
DNS.2 = *.$BASE_DOMAIN
EOF

# The file name can be anything
FILE_NAME="https-cert"

# Remove previous keys
echo "Removing existing certs like $FILE_NAME.*"
chmod 770 $FILE_NAME.*
rm $FILE_NAME.*


# RootCA start
# create rootCA.key
# This file will be used as the key to generate the Root SSL certificate
#openssl genrsa -des3 -out rootCA.key 2048

# You can use the key you generated to create a new Root SSL certificate
#openssl req -x509 -new -nodes -key rootCA.key -sha256 -days 1024 -out rootCA.pem
#C = IN
#ST = Maharashtra
#L = Pune
#O = thedarkcoderrises.org
#OU = tdcrOrgUnit
#emailAddress = thedarkcoderrises@gmail.com
#CN = Local Certificate
# RootCA end


echo "Generating certs for $BASE_DOMAIN"
# Generate our Private Key, CSR and Certificate
# Use SHA-2 as SHA-1 is unsupported from Jan 1, 2017
openssl req -new -sha256 -nodes -out "$FILE_NAME.csr" -newkey rsa:2048 -keyout "$FILE_NAME.key" -days $DAYS -passin pass:$PASSPHRASE -config "$CONFIG_FILE"


openssl x509 -req -in "$FILE_NAME.csr" -CA rootCA.pem -CAkey rootCA.key -CAcreateserial -out "$FILE_NAME.crt" -days $DAYS -sha256 -passin pass:$PASSPHRASE -extfile v3.ext

# OPTIONAL - write an info to see the details of the generated crt
#openssl x509 -noout -fingerprint -text < "$FILE_NAME.crt" > "$FILE_NAME.info"

# To create *.jks from *.crt and *.key
# Create PKCS 12 file using your private key and CA signed certificate of it. You can use openssl command for this.
openssl pkcs12 -export -in "$FILE_NAME.crt" -passin pass:$PASSPHRASE -inkey "$FILE_NAME.key" -certfile "$FILE_NAME.crt" -out "$FILE_NAME.p12"


keytool -importkeystore -srckeystore "$FILE_NAME.p12" -srcstoretype pkcs12 -destkeystore "$FILE_NAME.jks" -storepass $PASSPHRASE -keypass $PASSPHRASE -deststoretype JKS


# Protect the key
chmod 400 "$FILE_NAME.jks"

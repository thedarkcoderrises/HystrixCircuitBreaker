#getting base image
FROM nginx
RUN rm /etc/nginx/conf.d/default.conf
COPY /conf/ /etc/nginx/conf.d
#COPY /cert/ /etc/nginx/certs/
COPY /staticHTML/ /usr/share/nginx/html/
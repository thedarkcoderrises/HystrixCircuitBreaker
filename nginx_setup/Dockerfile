#getting base image
FROM nginx
RUN rm /etc/nginx/conf.d/default.conf
RUN rm /etc/nginx/nginx.conf
COPY /conf/default.conf /etc/nginx/conf.d
COPY /conf/nginx.conf /etc/nginx
COPY /conf/proxy.conf /etc/nginx
#COPY /cert/ /etc/nginx/certs/
COPY /staticHTML/ /usr/share/nginx/html/
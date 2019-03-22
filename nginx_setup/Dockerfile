#getting base image
FROM nginx
RUN rm /etc/nginx/conf.d/default.conf
RUN rm /etc/nginx/nginx.conf
COPY ./default.conf /etc/nginx/conf.d
COPY ./nginx.conf /etc/nginx
COPY ./proxy.conf /etc/nginx
COPY ./index.html /usr/share/nginx/html/
# Official mysql image
FROM mysql:8.0.19

# Adding my database
ENV MYSQL_DATABASE spring_security_db
ENV MYSQL_ROOT_PASSWORD root

# Add scripts from sql-scripts/ directory to image
# All scripts in docker-entrypoint-initdb.d/ are automagically executed during container startup
COPY ./sql-scripts/ /docker-entrypoint-initdb.d/

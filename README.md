# Apache Web Servlet

## Description

Web Framework di Java:
- Spring Web MVC
- Java Server Page
- Java Server Faces
- dll

Servlet itu spesifikasi ([link spesifikasi](https://jcp.org/en/jsr/detail?id=340)), sama seperti JDBC sebagai driver untuk koneksi ke DB. Untuk web server di java yang mengimplementasikan servlet ada:
- Apache Tomcat (lebih ringan dan open source, serta multiplatform (dpt dijalankan di OS manapun))
- Jetty
- Glassfish
- Wildfly
- dll

* Jika ingin membuat web server di java, pada spring init pilih war (web archive) sebagai packaging dan tambahkan dependency spring web.
* Interface `Servlet` docs: [see documentation](https://tomcat.apache.org/tomcat-7.0-doc/servletapi/javax/servlet/Servlet.html)
* Pada file `pom.xml` dan ketika menjalankan perintah `mvn package` untuk archive project, hapus `<build>` tag agar tidak ada ketergantungan dengan main class. 
* Setelah menjalankan perintah maven package, akan otomatis muncul file `D:\servlet\servlet\target\servlet-0.0.1-SNAPSHOT.war`. File war tersebut pindahkan ke direktori `webapps` dan rename nama folder agar lebih singkat. akses project dengan `localhost:8080/nama-folder/endpoint`

## Installation

For windows: [video tutorial](https://www.youtube.com/watch?v=vFddw-BAB8Y)

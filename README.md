<h1>ek-envater-Spring boot - micro servis - cloud</h1>

<ul>
	<li>spring-boot-env-microservis-1-data-rest projesinde data-rest ile &ccedil;alışan servis u&ccedil;ları</li>
	<li>spring-boot-env-microservis-2-service-dao&nbsp;projesinde proxy kullanılara &ccedil;ağrıldı. (@FeignClient)</li>
</ul>

<h3>&nbsp;</h3>

<h3>Kullanılan teknolojiler</h3>

<p>&nbsp;</p>

<ol>
	<li>Kullanılan teknolojiler</li>
	<li>Spring Boot 3.0.6</li>
	<li>Java 17</li>
	<li>spring-cloud-starter-config</li>
	<li>spring-cloud-starter-openfeign</li>
	<li>H2 data base</li>
	<li>Spring data jpa</li>
	<li>JpaRepository</li>
	<li>Spring data rest</li>
	<li>DAO</li>
	<li>Lombok</li>
	<li>spring-boot-starter-mail</li>
	<li>AOP for logging --&gt; t_envater_log</li>
	<li>exception handling</li>
</ol>

<h3>&nbsp;</h3>

<h3>GETget Depo id</h3>

<p>http://127.0.0.1:8888/env/depo/2</p>

<p>&nbsp;</p>

<h3>GETget Katalog id</h3>

<p>http://127.0.0.1:8888/env/katalog/2</p>

<p>&nbsp;</p>

<h3>GETget Depolar</h3>

<p>http://127.0.0.1:8888/env/depo</p>

<p>&nbsp;</p>

<h3>GETget Envanter</h3>

<p>http://127.0.0.1:8080/env/depo</p>

<p>&nbsp;</p>

<h3>GETget Envanter Entity</h3>

<p>http://127.0.0.1:8080/env/envanter</p>

<p>&nbsp;</p>

<h3>GETdelete Depo</h3>

<p>http://127.0.0.1:8080/env/depo</p>

<p>&nbsp;</p>

<h3>POSTinsert Depo</h3>

<p>http://127.0.0.1:8888/env/depo</p>

<p>&nbsp;</p>

<h3>POSTUpdate Depo</h3>

<p>http://127.0.0.1:8888/env/depo</p>

<p>&nbsp;</p>

<h3>DELETEDelete Depo</h3>

<p>http://127.0.0.1:8888/env/depo/5</p>

<p>&nbsp;</p>

<h3>POSTinsert Depo Envanter</h3>

<p>http://127.0.0.1:8080/data-rest/depoes</p>

<p>&nbsp;</p>

<h3>POSTinsert Envanter</h3>

<p>http://127.0.0.1:8080/data-rest/envanters</p>

<p>&nbsp;</p>

<h3>POSTupdate Envanter</h3>

<p>http://127.0.0.1:8080/data-rest/envanters</p>

<p>&nbsp;</p>

<h3>POSTinsert hareket</h3>

<p>http://127.0.0.1:8080/data-rest/envanterHarekets</p>

<p>&nbsp;</p>

<h3>POSTinsert hareket DAO</h3>

<p>http://127.0.0.1:8888/env/envanterHareket</p>

<p>&nbsp;</p>

<h3>PUTupdate hareket DAO</h3>

<p>http://127.0.0.1:8080/env/envanterHareket</p>

<p>&nbsp;</p>

<h3>PUTupdate Envanter</h3>

<p>http://127.0.0.1:8080/env/envanterHareket</p>

<p>&nbsp;</p>

<h3>PUTdelete hareket DAO</h3>

<p>http://127.0.0.1:8080/env/envanterHareket</p>

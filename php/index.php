<?php
header("Content-Type:text/html;charset=utf-8");
//ANPui-MacBook-Pro-2:bible anp$ java -cp ".:./sqlite-jdbc-3.16.1.jar" Program 창1:1
$k=$_GET['k'];
/* linux or mac 
chmod 755 ./* 필수 설정 구동이 안되는 경우 많음
/Library/WebServer/Documents/ 위치
sudo apachectl start
아파치 실행
sudo vi /etc/apache2/httpd.conf 설정에 맞게 수정
php 활성화, index.php ifModule 에 추가
linux or mac cp 만 다름 */
exec('java -cp ".:./sqlite-jdbc-3.16.1.jar" Program '.$k.' 2>&1',$output);

/* Windows */
exec('java -cp ".;./sqlite-jdbc-3.16.1.jar" Program '.$k.' 2>&1',$output);

while(list($key,$val)=each($output)){
	echo $val."<br>";
}
?>

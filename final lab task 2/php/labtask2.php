<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
  $value = $_REQUEST['value'];
  $from = $_REQUEST['from'];
  $to = $_REQUEST['to'];

  $data = file_get_contents("http://localhost:8080/spring_webmvc_war_exploded/currency/rate/from/" . $from ."/to/" . $to);
  $data = json_decode($data);
  echo "Result : " . ($data->rate * $value);
}
?>
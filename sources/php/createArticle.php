<?php
  require_once('Database.php');

  $db = new Database();

  $ART_NAME = $_POST['ART_NAME'];
  $BEZEICHNUNG = $_POST['BEZEICHNUNG'];
  $PREIS = $_POST['PREIS'];
  $GROESSE = $_POST['GROESSE'];
  $GEWICHT = $_POST['GEWICHT'];

  $db->createArtikel($ART_NAME, $BEZEICHNUNG, $PREIS, $GROESSE, $GEWICHT);
?>

<a href="index.php">go back :)</a>

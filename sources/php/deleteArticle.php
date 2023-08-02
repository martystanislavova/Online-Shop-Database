<?php
require_once('Database.php');

 $db = new Database();

 $ARTIKELNR = '';
if(isset($_POST['ARTIKELNR'])){
    $ARTIKELNR = $_POST['ARTIKELNR'];
    
}

 $db->deleteArtikel($ARTIKELNR);

?>

<a href="index.php">go back :)</a>

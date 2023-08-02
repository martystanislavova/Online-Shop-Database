<?php
require_once('Database.php');

 $db = new Database();

 $ARTIKELNR = '';
if(isset($_POST['id'])){
    $ARTIKELNR = $_POST['id'];
    
}

 $db->deleteArtikel($ARTIKELNR);

?>

<a href="index.php">go back :)</a>

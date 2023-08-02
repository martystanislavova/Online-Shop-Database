<?php

class Database
{
  protected $conn;

  const username = 'a11922120'; 
  const password = 'dbs22';
  const con_string = 'oracle-lab.cs.univie.ac.at:1521/orclcdb';

  public function __construct()
  {
    try {
      $this->conn = oci_connect(
        Database::username,
        Database::password,
        Database::con_string
      );

      if (!$this->conn) {
        die("DB error: Connection can't be established!");
      }
      
    } catch (Exception $e) {
      die("DB error: {$e->getMessage()}");
    }
  }

  public function __destruct()
  {
      oci_close($this->conn);
  }

  public function getAngestellte()
  {
    $sql = 'SELECT * FROM angestellter';
    $statement = oci_parse($this->conn, $sql);
    oci_execute($statement);
    oci_fetch_all($statement, $res, null, null, OCI_FETCHSTATEMENT_BY_ROW);
    oci_free_statement($statement);
    return $res;
  }

  public function getArtikel()
  {
    $sql = 'SELECT * FROM artikel ORDER BY artikelnr DESC';
    $statement = oci_parse($this->conn, $sql);
    oci_execute($statement);
    oci_fetch_all($statement, $res, null, null, OCI_FETCHSTATEMENT_BY_ROW);
    oci_free_statement($statement);
    return $res;
  }
    
   public function getBenutzer()
    {
      $sql = 'SELECT * FROM benutzer';
      $statement = oci_parse($this->conn, $sql);
      oci_execute($statement);
      oci_fetch_all($statement, $res, null, null, OCI_FETCHSTATEMENT_BY_ROW);
      oci_free_statement($statement);
      return $res;
    }

  public function createArtikel($ART_NAME, $BEZEICHNUNG, $PREIS, $GROESSE, $GEWICHT)
  {
    $sql = 'INSERT INTO artikel (ART_NAME, BEZEICHNUNG, PREIS, GROESSE, GEWICHT) VALUES (:ART_NAME, :BEZEICHNUNG, :PREIS, :GROESSE, :GEWICHT)';
    $statement = oci_parse($this->conn, $sql);
    oci_bind_by_name($statement, ':ART_NAME', $ART_NAME);
    oci_bind_by_name($statement, ':BEZEICHNUNG', $BEZEICHNUNG);
    oci_bind_by_name($statement, ':PREIS', $PREIS);
    oci_bind_by_name($statement, ':GROESSE', $GROESSE);
    oci_bind_by_name($statement, ':GEWICHT', $GEWICHT);
    oci_execute($statement);
    oci_free_statement($statement);
  }
    
    public function deleteArtikel($ARTIKELNR)
    {
         $sql = 'DELETE FROM ARTIKEL WHERE ARTIKELNR = {$ARTIKELNR}';
         $statement = oci_parse($this->conn, $sql);
         //oci_bind_by_name($statement, ':ARTIKELNR', $ARTIKELNR);
         oci_execute($statement);
         oci_free_statement($statement);
    }
    
  
        
    public function searchArtikel($ART_NAME) {
        $ART_NAME = $_GET['ART_NAME'];
        echo 'You searched for: ' . $ART_NAME;
        
      $sql = "SELECT * FROM artikel WHERE ART_NAME LIKE :ART_NAME";
      $statement = oci_parse($this->conn, $sql);
      oci_bind_by_name($statement, ':ART_NAME', $ART_NAME);
      oci_execute($statement);

      // Fetch the rows from the statement into an array
      $articles = [];
        error_reporting(E_ALL);
        ini_set("display_errors", 1);
        
      while ($row = oci_fetch_array($statement, OCI_ASSOC+OCI_RETURN_NULLS)) {
        $articles[] = $row;
      }
        echo"<br>";
        echo ' Number of items found: ' . count($articles);
        echo"<br>";

      return $articles;
    }
    
}


    //second version
    /*
    public function deleteArtikel($ARTIKELNR){
            $sql = "DELETE FROM kunde WHERE ARTIKELNR={$ARTIKELNR}";
            $statement = @oci_parse($this->conn, $sql);
            $delete = @oci_execute($statement) && @oci_commit($this->conn);
            @oci_free_statement($statement);
            return $delete;
        } */


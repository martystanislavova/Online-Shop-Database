<link rel="stylesheet" href="styles.css" />
<table>
        <thead>
          <caption>Angestellten</caption>
          <th>Vorname</th>
          <th>Nachname</th>
          <th>Wohnort</th>
        </thead>
        <tbody>
        <?php foreach($angestellte as $key=>$value){ ?>
            <tr>
                <td class="narrow"><?php echo $value['ANG_VORNAME']; ?></td>
                <td class="narrow"><?php echo $value['ANG_NACHNAME']; ?></td>
                <td class="narrow"><?php echo $value['WOHNORT']; ?> </td>
            </tr>
        <?php } ?>
        </tbody>
      </table>

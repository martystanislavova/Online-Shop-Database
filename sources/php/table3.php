<table>
        <thead>
          <caption>Users</caption>
          <th class="narrow">Vorname</th>
          <th class="narrow">Nachname</th>
          <th class="narrow">Email</th>
        </thead>
        <tbody>
        <?php foreach($benutzer as $key=>$value){ ?>
            <tr>
                <td class="narrow"><?php echo $value['USER_VORNAME']; ?></td>
                <td class="narrow"><?php echo $value['USER_NACHNAME']; ?></td>
                <td class="narrow"><?php echo $value['EMAIL']; ?> </td>
            </tr>
        <?php } ?>
        </tbody>
      </table>

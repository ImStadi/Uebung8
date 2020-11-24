package controllerView;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import model.CurrencyConverter;

import java.net.URL;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Currency;
import java.util.ResourceBundle;

/**
 * Controller für CurrencyConverter
 */
public class CurrencyConverterC implements Initializable
{
  @FXML
  private TextField txtEuro;
  @FXML
  private TextField txtYen;
  @FXML
  private ChoiceBox choiceBox;
  
  private CurrencyConverter currencyConverter;
  
  private static final  NumberFormat DEC2FORMAT;
  
  static {
    DEC2FORMAT = NumberFormat.getNumberInstance();
    DEC2FORMAT.setGroupingUsed(true);
    DEC2FORMAT.setMinimumFractionDigits(2);
    DEC2FORMAT.setMaximumFractionDigits(2);
  }
  
  /**
   * Passiert, wenn der Umrechnungs-Button gedrückt wird
   */
  @FXML
  public void btnConvertAction() {
    //  besser in Methode auslagern, weil gleiche Funktionalitäten via GUIs häufig auf verschiedene Weisen aufgerufen werden können.
    convert();
  }
  
  
  /**
   * Konstruktor.
   * Es muss ein öffentlicher Standardkonstruktor (noArg) existieren. Entweder explizit angegeben oder per Default generiert.
   */
  public CurrencyConverterC() {
    currencyConverter = new CurrencyConverter();
  }
  
  /**
   * Konvertierung Euro -> Yen
   */
  private void convert() {
    try {
//    double euro = Double.parseDouble(txtEuro.getText());
      double euro = DEC2FORMAT.parse(txtEuro.getText()).doubleValue();
      String input = (String)choiceBox.getValue();
      double yen = currencyConverter.euroTo(input,euro);
//    txtYen.setText(String.valueOf(yen));
      txtYen.setText(DEC2FORMAT.format(yen));
    }
    catch (ParseException e)
    {
      System.out.println(e.getMessage());
//    txtMsg.setText(e.GetMessage);
    }
  }


  @Override
  public void initialize(URL url, ResourceBundle resourceBundle)
  {
    fill();
    currencyConverter = new CurrencyConverter();
  }
  public void fill()
  {
    for (int i = 0; i < currencyConverter.database.size(); i++)
    {
      Object a =choiceBox.getItems().add(currencyConverter.getSign(i));
    }
  }

}

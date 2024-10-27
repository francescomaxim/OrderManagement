package start;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import bll.ClientBLL;
import bll.ComenziBLL;
import bll.ProductBLL;
import com.itextpdf.text.*;
import dao.AbstractDAO;
import model.Client;
import model.Comenzi;
import model.Product;
import presentation.View;
public class Start {
	protected static final Logger LOGGER = Logger.getLogger(Start.class.getName());

	/***
	 * functia main
	 * @param args argumentele functiei(nule la noi)
	 * @throws SQLException sql exception
	 * @throws DocumentException document exception
	 * @throws FileNotFoundException pdf exception
	 */
	public static void main(String[] args) throws SQLException, DocumentException, FileNotFoundException {

		View view = new View();
//		StudentBLL studentBll = new StudentBLL();
		ClientBLL clientBLL = new ClientBLL();
		List<Client> clients = new ArrayList<>();
		Client client = new Client(22,"mihai_boss33","gherla2","ce2va@yahoo.com",32);
		ProductBLL productBLL = new ProductBLL();
		List<Product> products = new ArrayList<>();
		Product p = new Product(6,"Ice2 Cream Cake",40,20);
		ComenziBLL comenziBLL = new ComenziBLL();
		List<Comenzi> comenziList = new ArrayList<>();
		try {
			Client qqq = clientBLL.findClientById(1);
			clientBLL.insert(qqq);
		} catch (Exception ex) {
			LOGGER.log(Level.INFO, ex.getMessage());
		}

	}

}

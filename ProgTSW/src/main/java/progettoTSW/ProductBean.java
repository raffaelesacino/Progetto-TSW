package progettoTSW;


import java.io.Serializable;




public class ProductBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	int code;
	String name;
	String description;
	int price;
	int quantity;
	String immagine;

	public ProductBean() {
		code = -1;
		immagine= "";
		name = "";
		description = "";
		quantity = 0;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getimmagine() {
		return immagine;
	}

	public void setimmagine(String immagini) {
		this.immagine = immagini;
	}
	
	public void clear() {
		this.clear();
	}
	
	@Override
	public String toString() {
		return name + " (" + code + "), " + immagine + " " + price + " " + quantity + ". " + description;
	}

}

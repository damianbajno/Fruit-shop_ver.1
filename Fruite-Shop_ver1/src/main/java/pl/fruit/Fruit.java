package pl.fruit;

public class Fruit {

     private String name;
     private float price;
     private String pictureAddress;



     public Fruit() {
	  super();
     }



     public Fruit(String name, long price, String pictureAddress) {
	  super();
	  this.name = name;
	  this.price = price;
	  this.pictureAddress = pictureAddress;
     }



     public Fruit(String language, String name, long price,
	       String pictureAddress) {
	  super();
	  this.name = name;
	  this.price = price;
	  this.pictureAddress = pictureAddress;
     }



     public String getName() {
	  return name;
     }



     public void setName(String name) {
	  this.name = name;
     }



     public float getPrice() {
	  return price;
     }



     public void setPrice(long price) {
	  this.price = price;
     }



     public String getPictureAddress() {
	  return pictureAddress;
     }



     public void setPictureAddress(String pictureAddress) {
	  this.pictureAddress = pictureAddress;
     }



     @Override
     public int hashCode() {
	  final int prime = 31;
	  int result = 1;
	  result = prime * result + ((name == null) ? 0 : name.hashCode());
	  result = prime
		    * result
		    + ((pictureAddress == null) ? 0 : pictureAddress.hashCode());
	  long temp;
	  temp = Double.doubleToLongBits(price);
	  result = prime * result + (int) (temp ^ (temp >>> 32));
	  return result;
     }



     @Override
     public boolean equals(Object obj) {
	  if (this == obj)
	       return true;
	  if (obj == null)
	       return false;
	  if (getClass() != obj.getClass())
	       return false;
	  Fruit other = (Fruit) obj;
	  if (name == null) {
	       if (other.name != null)
		    return false;
	  } else if (!name.equals(other.name))
	       return false;
	  if (pictureAddress == null) {
	       if (other.pictureAddress != null)
		    return false;
	  } else if (!pictureAddress.equals(other.pictureAddress))
	       return false;
	  if (Double.doubleToLongBits(price) != Double
		    .doubleToLongBits(other.price))
	       return false;
	  return true;
     }



     @Override
     public String toString() {
	  return "fruit [ " + "name=" + name + ", price=" + price
		    + ", pictureAddress=" + pictureAddress + "]";
     }

}

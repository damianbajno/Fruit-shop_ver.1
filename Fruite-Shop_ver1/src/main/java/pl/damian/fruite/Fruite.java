package pl.damian.fruite;

public class Fruite {

	private String name;
	private long prise;
	private String pictureAdress;

	public Fruite() {
		super();
	}

	public Fruite(String name, long prise, String pictureAdress) {
		super();
		this.name = name;
		this.prise = prise;
		this.pictureAdress = pictureAdress;
	}

	public Fruite(String language, String name, long prise, String pictureAdress) {
		super();
		this.name = name;
		this.prise = prise;
		this.pictureAdress = pictureAdress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPrise() {
		return prise;
	}

	public void setPrise(long prise) {
		this.prise = prise;
	}

	public String getPictureAdress() {
		return pictureAdress;
	}

	public void setPictureAdress(String pictureAdress) {
		this.pictureAdress = pictureAdress;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((pictureAdress == null) ? 0 : pictureAdress.hashCode());
		result = prime * result + (int) (prise ^ (prise >>> 32));
		return result;
	}

	@Override
	public String toString() {
		return "Fruite [ " + "name=" + name + ", prise=" + prise
				+ ", pictureAdress=" + pictureAdress + "]";
	}

}

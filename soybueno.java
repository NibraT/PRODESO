public class DiegoDB
{
	public DiegoDB(String fileName)
	{
		this.m_fileName = fileName;
		this.m_sqlitedb = null;
		
		try
		{
		  Class.forName("org.sqlite.JDBC");
		  this.m_sqlitedb = DriverManager.getConnection("jdbc:sqlite:" + fileName);
		}
		catch(Exception e)
		{
		  //System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		//System.out.println("Opened database successfully");
	}
	
	public boolean isOpen()
	{
		return this.m_sqlitedb != null;
	}
	
	public boolean query(String queryStr)
	{
		Statement stmt = null;
		try {
		  stmt = this.m_sqlitedb.createStatement(); 
		  stmt.executeUpdate(queryStr);
		  stmt.close();
		  return true;
		} catch ( Exception e ) {
		}
		return false;
	}
	
	private Connection m_sqlitedb;
	
	private String m_fileName = "";
}

public class RemisoftDB extends DiegoDB
{
	public void agregarKilometros(String patente, int km)
	{
		// implementacion
	}
}


DiegoDB remisoftdb = new DiegoDB("remisoft.db");

if(remisoftdb.isOpen())
{
	String patente = "???";
	remisoftdb.query("SELECT KILOMETROS FROM VEHICULO WHERE PATENTE = " + patente);
	int km = remisoftdb.resultadoDeLaQueryAnterior().getColumn("KILOMETROS").asInt() + kilometrosQueCargoNora;
	remisoftdb.query("UPDATE TABLE VEHICULO(KILOMETROS) SET(" + km + ") WHERE ");
	// Hago queries como un campeon
}
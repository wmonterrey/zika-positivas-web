package ni.org.ics.zip.utils;

/**
 * Created by FIRSTICT on 11/14/2016.
 * V1.0
 */
public class ExportParameters {

    private String tableName;
    private String codigoInicio;
    private String codigoFin;

    public ExportParameters(String tableName, String codigoInicio, String codigoFin) {
        this.tableName = tableName;
        this.codigoInicio = codigoInicio;
        this.codigoFin = codigoFin;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getCodigoInicio() {
        return codigoInicio;
    }

    public void setCodigoInicio(String codigoInicio) {
        this.codigoInicio = codigoInicio;
    }

    public String getCodigoFin() {
        return codigoFin;
    }

    public void setCodigoFin(String codigoFin) {
        this.codigoFin = codigoFin;
    }

    public boolean thereAreValues(){
        return (this.getCodigoInicio()!=null && this.getCodigoFin() !=null && !this.getCodigoInicio().isEmpty() && !this.getCodigoFin().isEmpty());
    }
}
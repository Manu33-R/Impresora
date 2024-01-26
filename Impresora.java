public class Impresora {
    private int toner;
    private int paginas = 0;
    private boolean tipimpresion;

    public Impresora(int toner, int paginas, boolean tipimpresion) {
        if (toner < 0 ||  toner > 100)
            this.toner = -1;
        else
            this.toner = toner;
        this.paginas=paginas;
        this.tipimpresion = tipimpresion;
    }

    @Override
    public String toString() {
        return "Impresora{" +
                "toner=" + toner +
                ", paginas=" + paginas +
                ", tipimpresion=" + tipimpresion +
                '}';
    }

    public int addToner(int canttoner){//Añadir toner
    if (canttoner < 0 ||  canttoner > 100 || this.toner + canttoner > 100)
        this.toner = -1;
    else
        this.toner += canttoner;
    return toner;
    }

    public int impPag(int cantpag){//Imprimir paginas
        if (cantpag < 0){
            cantpag = 0;
        }else
        if (tipimpresion) {
            if (cantpag % 2 != 0) {
                cantpag += 1;
            }
            cantpag /= 2;
        }
            this.paginas+=cantpag;
        return cantpag;
    }

    public int getToner() {
        return toner;
    }

    public void setToner(int toner) {
        this.toner = toner;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public boolean isTipimpresion() {
        return tipimpresion;
    }

    public void setTipimpresion(boolean impresion) {
        this.tipimpresion = impresion;
    }
}

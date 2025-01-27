package ListadeAerorportos;

import Airport.Airport;
import ListaDeVoos.ListaDeVoos;
import ListaDuplamenteLigadaDesordenadaSemRepeticao.ListaDuplamenteLigadaDesordenadaSemRepeticao;

public class ListaDeAeroportos extends ListaDuplamenteLigadaDesordenadaSemRepeticao<Airport> {
    public ListaDeAeroportos() throws Exception {
        super();
    }

    public boolean temAeroporto(Airport other) throws Exception {
        if(other == null)
            throw new Exception("Aeroporto nao fornecido!");

        No atual = this.primeiro;
        Airport airport = null;
        while(atual != null) {
            airport = (Airport) atual.getInfo();
            if(other.getAirportCode() == airport.getAirportCode())
                return true;
            if(other.getCityName().equals(airport.getCityName()))
                return true;

            atual = atual.getProx();
        }

        return false;
    }

    public boolean temAeroporto(int code) throws Exception {
        if(code == 0)
            throw new  Exception("Codigo nao fornecido!");

        No atual = this.primeiro;
        Airport airport = null;
        while(atual != null) {
            airport = (Airport) atual.getInfo();
            if(code == airport.getAirportCode())
                return true;

            atual = atual.getProx();
        }

        return false;
    }

    public boolean temDeterminadoVooComCodigo(int routeCode) throws Exception {
        if (routeCode < 0)
            throw new Exception ("Código de rota não fornecido");

        No atual = this.primeiro;
        Airport airport = null;
        while(atual!=null)
        {
            airport = (Airport)atual.getInfo();

            ListaDeVoos lis = airport.getRoutes();
            if(lis.temVooComCodigo(routeCode))
                return true;

            atual = atual.getProx();
        }
        return false;
    }

    @Override
    public void insereNoInicio(Airport airport) throws Exception {
        if(airport == null)
            throw new Exception("Aeroporto nao fornecido!");

        if(temAeroporto(airport))
            throw new Exception("Aerorporto repetido!");

        super.insiraNoInicio(airport);
    }

    @Override
    public void insereNoFim(Airport airport) throws Exception {
        if(airport == null)
            throw new Exception("Aeroporto nao fornecido!");

        if(temAeroporto(airport))
            throw new Exception("Aeroporto repetido!");

        super.insiraNoFim(airport);
    }

    @Override
    public String toString() {
        String ret = "[\n";

        No atual=this.primeiro;

        while(atual!=null) {
            ret = ret + atual.getInfo();

            if(atual != this.ultimo)
                ret = ret + ",\n";

            atual=atual.getProx();
        }

        return ret+"\n]";
    }

    public ListaDeAeroportos(ListaDeAeroportos model) throws Exception{
        super(model);
    }

    public Object clone() {
        ListaDeAeroportos ret = null;
        try {
            ret = new ListaDeAeroportos(this);
        } catch (Exception err) {}

        return ret;
    }
}

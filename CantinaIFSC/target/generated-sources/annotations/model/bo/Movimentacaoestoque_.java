package model.bo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.bo.Funcionario;
import model.bo.ItemCompra;
import model.bo.ItemVenda;
import model.bo.Produto;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-04-01T20:12:33")
@StaticMetamodel(Movimentacaoestoque.class)
public class Movimentacaoestoque_ { 

    public static volatile SingularAttribute<Movimentacaoestoque, ItemCompra> compra;
    public static volatile SingularAttribute<Movimentacaoestoque, ItemVenda> itemVenda;
    public static volatile SingularAttribute<Movimentacaoestoque, Produto> produto;
    public static volatile SingularAttribute<Movimentacaoestoque, Character> flagtipomovimento;
    public static volatile SingularAttribute<Movimentacaoestoque, Float> qtdmovimentada;
    public static volatile SingularAttribute<Movimentacaoestoque, Integer> id;
    public static volatile SingularAttribute<Movimentacaoestoque, Funcionario> funcionario;
    public static volatile SingularAttribute<Movimentacaoestoque, String> observacaomovimento;
    public static volatile SingularAttribute<Movimentacaoestoque, String> datahoramovimento;
    public static volatile SingularAttribute<Movimentacaoestoque, String> status;

}
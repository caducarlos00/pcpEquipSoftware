##Diagrama de Classes

'''
classDiagram
    class Produto {
        String codigo
        String nome
        String descricao
        int quantidade
        String marca
        String modelo
        double valorCompra
        double valorVenda
        Date dataCompra
        Fornecedor fornecedor
        Categoria categoria
    }

    class Fornecedor {
        String nome
        String cnpjCpf
        String telefone
        String email
    }

    class Categoria {
        String codigo
        String nome
        String descricao
    }

    class OrdemDeServico {
        String codigo
        Date dataEntrada
        Date dataSaida
        Cliente cliente
        List~Produto~ produtosUtilizados
        String descricaoServico
        String status
        double valorTotal
    }

    class Cliente {
        String nome
        String cnpjCpf
        String telefone
        String email
        String endereco
    }

    class OrdemDeCompra {
        String codigo
        Date data
        Fornecedor fornecedor
        List~Produto~ produtosComprados
        int quantidade
        double valorTotal
        String status
    }

    Produto --> Fornecedor : fornecedor
    Produto --> Categoria : categoria
    OrdemDeServico --> Cliente : cliente
    OrdemDeServico --> Produto : produtosUtilizados
    OrdemDeCompra --> Fornecedor : fornecedor
    OrdemDeCompra --> Produto : produtosComprados
'''

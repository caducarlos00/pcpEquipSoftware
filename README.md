##Sistema de controle de Estoque

#Projeto criado para estudo.
Criando um software para controle de estoque de uma oficina de compressores.

Tecnologias utilizadas:
Java 21;
SpringBoot Data JPA;
SpringBoot WebServices;

##Diagrama de Classes

``` mermaid
classDiagram
    class Product {
        Long id
        String code
        String name
        String description
        int quantity
        String brand
        String model
        double purchasePrice
        double salePrice
        Date purchaseDate
        ContactGeneral supplier
        Category category
    }

    class ContactGeneral {
        Long id
        String name
        String federalRegistration
        String phone
        String email
        String address
        String type
    }

    class Category {
        Long id
        String code
        String name
        String description
    }

    class ServiceOrder {
        Long id
        String code
        Date entryDate
        Date exitDate
        ContactGeneral client
        List~Product~ productsUsed
        String serviceDescription
        String status
        double totalPrice
    }

    class PurchaseOrder {
        Long id
        String code
        Date date
        ContactGeneral supplier
        List~Product~ productsPurchased
        int quantity
        double totalPrice
        String status
    }

    Product --> ContactGeneral : supplier
    Product --> Category : category
    ServiceOrder --> ContactGeneral : client
    ServiceOrder --> Product : productsUsed
    PurchaseOrder --> ContactGeneral : supplier
    PurchaseOrder --> Product : productsPurchased
```

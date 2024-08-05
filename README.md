##Diagrama de Classes

```classDiagram
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
        Supplier supplier
        Category category
    }

    class Supplier {
        Long id
        String name
        String taxId
        String phone
        String email
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
        Client client
        List~Product~ productsUsed
        String serviceDescription
        String status
        double totalPrice
    }

    class Client {
        Long id
        String name
        String taxId
        String phone
        String email
        String address
    }

    class PurchaseOrder {
        Long id
        String code
        Date date
        Supplier supplier
        List~Product~ productsPurchased
        int quantity
        double totalPrice
        String status
    }

    Product --> Supplier : supplier
    Product --> Category : category
    ServiceOrder --> Client : client
    ServiceOrder --> Product : productsUsed
    PurchaseOrder --> Supplier : supplier
    PurchaseOrder --> Product : productsPurchased
```

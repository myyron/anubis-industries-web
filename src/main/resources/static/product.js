class Product {

    constructor() {
        const table = new DataTable('#table-product', {
            ajax: '/product/list'
        });
    }
}
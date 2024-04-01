class Product {

    constructor() {
        const table = new DataTable('#table-product', {
            ajax: {
                url: '/product/list',
                dataSrc: ''
            },
            columns: [
                {data: 'name'},
                {data: 'variation'}
            ]
        });
    }
}
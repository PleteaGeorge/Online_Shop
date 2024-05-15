
function addToCart(productId) {
    fetch("http://localhost:8080/addToCart/" + productId, {
        method: 'POST',
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Error while trying to add the product to cart');
        }
        console.log('Request successful');
        alert("Product added to cart!");
    })
    .catch(error => {
        console.error('Request failed:', error);
    });
}


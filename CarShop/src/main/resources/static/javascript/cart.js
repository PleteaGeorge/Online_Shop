
    function calculateTotal() {
    console.log("methode called");
        var total = 0;
        var prices = document.querySelectorAll('.product-price');

        prices.forEach(function(priceElement) {
            var price = parseFloat(priceElement.textContent);
            total += price;
        });

        document.getElementById('total').textContent = total;
    }
    window.onload = calculateTotal;

     var removeButton = document.getElementById('remove');
     removeButton.addEventListener('click', calculateTotal);

    function remove (productId){
    console.log(productId);
    fetch("http://localhost:8080/removeFromCart/" + productId, {
            method: 'PATCH',
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Error while trying to remove the product from cart');
            }
            console.log('Request successful'+ response);
              location.reload();
        })
        .catch(error => {
            console.error('Request failed:', error);
        });


    }
     function buy() {
         fetch("http://localhost:8080/buy", {
             method: 'POST',
         })
         .then(response => {
             if (!response.ok) {
                 throw new Error('Error while trying to buy the products');
             }
             console.log('Request successful'+ response);
             alert("Multumim pentru achizitie!")
             location.reload();
         })
         .catch(error => {
             console.error('Request failed:', error);
         });
     }

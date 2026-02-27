Feature: Flujo de compra E2E en Demoblaze
  Como un usuario de la tienda
  Quiero agregar productos al carrito y llenar el formulario
  Para poder finalizar una compra exitosamente

  Scenario: Compra exitosa de dos productos
    Given que el cliente se encuentra en la pagina de inicio
    When agrega el producto "Samsung galaxy s6" al carrito
    And agrega el producto "Nokia lumia 1520" al carrito
    And completa el formulario de compra
    Then deberia ver el mensaje de confirmacion "Thank you for your purchase!"
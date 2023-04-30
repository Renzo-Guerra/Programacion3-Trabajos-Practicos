package TP3;

public class GrafoNoDirigidoV2<T> extends GrafoDirigidoV2<T> {
  // Al agregar el arco, lo hace en ambas direcciones 
  @Override
  public void agregarArco(int verticeId1, int verticeId2, T etiqueta){
    super.agregarArco(verticeId1, verticeId2, etiqueta);
    super.agregarArco(verticeId2, verticeId1, etiqueta);
  }

  // Al eliminar el arco, lo hace en ambas direcciones 
  @Override
  public void borrarArco(int verticeId1, int verticeId2) {
    super.borrarArco(verticeId1, verticeId2);
    super.borrarArco(verticeId2, verticeId1);
  }

  @Override
  public int cantidadArcos(){
    return (super.cantidadArcos() / 2);
  }

  /*
   ! La clase pasada dijeron que tambien hay que 
   ! dividir x 2 el numero de arcos, ya que estos 
   ! son como 1 solo, pero entonces, que hacemos 
   ! con obtenerArcos? Tambien debemos devolver solo 1 
   ! de los 2 arcos? 
   */

}

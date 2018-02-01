package assignment06;

public class Server{
  private MComp allMenus;

  public Server(MComp allMenus){
    this.allMenus = allMenus;
  }

  public void printMenu(){
    System.out.print("\nALL MENUS\n----");
    for(MComp comp : allMenus) {
    		comp.print();
    }
  }

  public void printVegetarianMenu(){
    System.out.print("\nVEGETARIAN MENU\n----");
    for(MComp comp : allMenus){
      if(comp instanceof MenuItem && comp.isVegetarian()){
        comp.print();
      }
    }
  }
}
package myclassproject.mystorygraph;

//Added by Kiet Huynh
//Consulted by Tri Huynh, and Hoang Dieu Linh Nguyen
public final class MyStoryEntities {
	public static final Characters edmona = new Characters("Edmona", BodyTypes.A, Clothing.Merchant, HairStyle.Long, Colors.Red, 1);
	public static final Characters garry = new Characters("Garry", BodyTypes.F, Clothing.Noble, HairStyle.Sticky, Colors.Black, 4);
	public static final Characters delphine = new Characters("Delphine", BodyTypes.E, Clothing.Priest, HairStyle.Ponytail, Colors.Black, 3);
	public static final Characters quentin = new Characters("Quentin", BodyTypes.H, Clothing.Warlock, HairStyle.Bald, Colors.Black, 7);
	public static final Characters grimspire = new Characters("Grimspire", BodyTypes.B, Clothing.King, HairStyle.Musketeer_Full, Colors.Black, 5);
	public static final Characters brother = new Characters("Brother", BodyTypes.D, Clothing.Noble, HairStyle.Long, Colors.Black, 5);
	public static final Characters father = new Characters("Father", BodyTypes.F, Clothing.Noble, HairStyle.Mage_Full, Colors.Black, 5);
	public static final Place bedroom1 = new Place("Edmona's Bedroom", PlaceTypes.CastleBedroom); // where edmona gets abducted
	public static final Place bedroom2 = new Place("Grimspire's Bedroom", PlaceTypes.CastleBedroom); // where grimspire is
	public static final Place camp = new Place("Home", PlaceTypes.Camp); // edmona runs away when garry is sleeping
	public static final Place town = new Place("Town", PlaceTypes.City); // edmona runs to after getting out of the forest
	public static final Place lightforest = new Place("Light Forest", PlaceTypes.ForestPath); // edmona practices light magic
	public static final Place darkforest = new Place("Dark Forest", PlaceTypes.SpookyPath); // edmona learns dark magic
	public static final Place ruins = new Place("Ruins", PlaceTypes.Ruins); // edmona learns dark magic
	public static final Place library = new Place("Library", PlaceTypes.Library); // edmona learns dark magic
	public static final Place hallway = new Place("Hallway", PlaceTypes.Hallway); // garry's initial spot
	public static final Item sword = new Item("Sword", ItemTypes.Sword);
	public static final Furniture cottageDoor = new Furniture(hallway, FurnitureTypes.Door);
	public static final Furniture table = new Furniture(hallway, FurnitureTypes.Table);
	public static final Furniture chair = new Furniture(hallway, FurnitureTypes.Chair);
	public static final Furniture cityDoor = new Furniture(town, FurnitureTypes.RedHouseDoor);
	public static final Furniture cityExit = new Furniture(town, FurnitureTypes.NorthEnd);
}

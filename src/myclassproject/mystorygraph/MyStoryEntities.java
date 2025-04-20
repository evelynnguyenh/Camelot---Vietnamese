package myclassproject.mystorygraph;

import com.entities.*;
import com.enums.*;

//Added by Kiet Huynh
//Consulted by Tri Huynh, and Hoang Dieu Linh Nguyen
public final class MyStoryEntities {
	public static final Characters edmona = new Characters("Edmona", BodyTypes.A, Clothing.Merchant, HairStyle.Long, Colors.Red, 1);
	public static final Characters garry = new Characters("Garry", BodyTypes.F, Clothing.Noble, HairStyle.Spiky, Colors.Black, 4);
	public static final Characters delphine = new Characters("Delphine", BodyTypes.E, Clothing.Priest, HairStyle.Ponytail, Colors.Black, 3);
	public static final Characters quentin = new Characters("Quentin", BodyTypes.H, Clothing.Warlock, HairStyle.Bald, Colors.Black, 7);
	public static final Characters grimspire = new Characters("Grimspire", BodyTypes.B, Clothing.King, HairStyle.Musketeer_Full, Colors.Black, 5);
	public static final Characters brother = new Characters("Brother", BodyTypes.D, Clothing.Noble, HairStyle.Long, Colors.Black, 5);
	public static final Characters father = new Characters("Father", BodyTypes.F, Clothing.Noble, HairStyle.Mage_Full, Colors.Black, 5);
	public static final Characters noble1 = new Characters("Noble Man 1", BodyTypes.D, Clothing.Noble, HairStyle.Long, Colors.Black, 6);
	public static final Characters noble2 = new Characters("Noble Man 2", BodyTypes.E, Clothing.Noble, HairStyle.Long, Colors.Black, 4);
	public static final Characters noble3 = new Characters("Noble Man 3", BodyTypes.F, Clothing.Noble, HairStyle.Spiky, Colors.Black, 3);
	public static final Characters noble4 = new Characters("Noble Man 4", BodyTypes.G, Clothing.Noble, HairStyle.Spiky, Colors.Black, 7);
	public static final Characters noble5 = new Characters("Noble Man 5", BodyTypes.H, Clothing.Noble, HairStyle.Short, Colors.Black, 3);
	public static final Place bedroom1 = new Place("Edmona's Bedroom", PlaceTypes.CastleBedroom); // where edmona gets abducted
	public static final Place bedroom2 = new Place("Grimspire's Bedroom", PlaceTypes.CastleBedroom); // where grimspire is
	public static final Place camp = new Place("Home", PlaceTypes.Camp); // edmona runs away when garry is sleeping
	public static final Place town = new Place("Town", PlaceTypes.City); // edmona runs to after getting out of the forest
	public static final Place lightforest = new Place("Light Forest", PlaceTypes.ForestPath); // edmona practices light magic
	public static final Place darkforest = new Place("Dark Forest", PlaceTypes.SpookyPath); // edmona learns dark magic
	public static final Place ruins = new Place("Ruins", PlaceTypes.Ruins); // edmona learns dark magic
	public static final Place library = new Place("Library", PlaceTypes.Library); // edmona learns dark magic
	public static final Place hallway = new Place("Hallway", PlaceTypes.Hallway); // garry's initial spot
	public static final Place greathall = new Place("Throne", PlaceTypes.GreatHall);
	public static final Item sword = new Item("Sword", ItemTypes.Sword);
	public static final Furniture stand = new Furniture(library, FurnitureTypes.Stand);
	public static final Furniture libraryspellbook = new Furniture(library, FurnitureTypes.SpellBook);
	public static final Furniture door = new Furniture(library, FurnitureTypes.Door);
	public static final Item spellbook = new Item("SpellBook", ItemTypes.SpellBook);
	public static final Item littorch = new Item("LitTorch", ItemTypes.LitTorch);
	public static final Furniture cottageDoor = new Furniture(hallway, FurnitureTypes.Door);
	public static final Furniture table = new Furniture(hallway, FurnitureTypes.Table);
	public static final Furniture chair = new Furniture(hallway, FurnitureTypes.Chair);
	public static final Furniture cityDoor = new Furniture(town, FurnitureTypes.RedHouseDoor);
	public static final Furniture bed = new Furniture(bedroom1, FurnitureTypes.Bed);
	public static final Furniture cityExit = new Furniture(town, FurnitureTypes.NorthEnd);
	public static final Furniture forestEnd = new Furniture(lightforest, FurnitureTypes.WestEnd);
	public static final Furniture throne = new Furniture(greathall, FurnitureTypes.Throne);
	public static final Furniture leftthrone = new Furniture(greathall, FurnitureTypes.LeftThrone);
	public static final Furniture rightthrone = new Furniture(greathall, FurnitureTypes.RightThrone);
	public static final Furniture forestexit = new Furniture(darkforest, FurnitureTypes.EastEnd);
}

package com.example.admin.moviefeel;

import java.io.IOException;
import java.lang.*;
import java.util.HashMap;
import java.util.List;

public class MainTest {
    public static void main(String [ ] args) throws IOException {

        //id
        String requete = RequeteTMDB.id(550);
        System.out.println("Id");
        RequeteTMDB.affichageRequete(requete);

        //search
        requete = RequeteTMDB.search("infinity+War");
        System.out.println("Recherche");
        RequeteTMDB.affichageRequete(requete);

        //discover
        requete = RequeteTMDB.discover("primary_release_date.gte=2014-09-15");
        System.out.println("Discover");
        RequeteTMDB.affichageRequete(requete);

        //dicover avec page
        requete = RequeteTMDB.discover("primary_release_date.gte=2014-09-15", 2);
        String affichage = RequeteTMDB.affichageRequete(requete);
        System.out.println("-- -- -- \n" + affichage);

        //discover genre
        requete = RequeteTMDB.discoverGenres("primary_release_date.gte=2018-09-15", "" + GenreIdTMDB.getId("Action"));
        System.out.println("Genre");
        RequeteTMDB.affichageRequete(requete);

        //Exemple pour recuperer une infos
        List<HashMap<String, String>> liste = RequeteTMDB.hashMapRequete(requete);
        System.out.println("contenu de la liste: " + liste);/*Affiche : [
        {id=424783}, {overview=On the run in the year 1987, Bumblebee finds refuge in a junkyard in a small Californian beach town. Charlie, on the cusp of turning 18 and trying to find her place in the world, discovers Bumblebee, battle-scarred and broken.  When Charlie revives him, she quickly learns this is no ordinary yellow VW bug., original_language=en, original_title=Bumblebee, release_date=2018-12-15},{vote_count, id=297802, title=Bumblebee, genre_ids=[28,12,878]}, {overview=Arthur Curry learns that he is the heir to the underwater kingdom of Atlantis, and must step forward to lead his people and be a hero to the world., original_language=en, original_title=Aquaman, release_date=2018-12-07},
        {vote_count, id=390634, title=Aquaman, genre_ids=[28,14,878,12]}, {overview=Theatrical-release adaptation of the visual novel \Fate\/stay night\, following the third and final route. (Part 2 of a trilogy.), original_language=ja, original_title=劇場版「Fate\/stay night [Heaven's Feel] ⅠⅠ. lost butterfly」, release_date=2019-01-12},{vote_count, id=446807, title=Fate\/stay night: Heaven’s Feel II. lost butterfly, genre_ids=[16,28,14]}, {overview=In Stockholm, Sweden, hacker Lisbeth Salander is hired by Frans Balder, a computer engineer, to retrieve a program that he believes it is too dangerous to exist., original_language=en, original_title=The Girl in the Spider's Web, release_date=2018-10-26},{vote_count, id=399402, title=The Girl in the Spider's Web, genre_ids=[18,53,9648,80,28]}, {overview=An untested American submarine captain teams with U.S. Navy SEALs to rescue the Russian president, who has been kidnapped by a rogue general., original_language=en, original_title=Hunter Killer, release_date=2018-10-19},{vote_count, id=480530, title=Hunter Killer, genre_ids=[28,53]}, {overview=Follows Adonis Creed's life inside and outside of the ring as he deals with new found fame, issues with his family, and his continuing quest to become a champion., original_language=en, original_title=Creed II, release_date=2018-11-21},{vote_count, id=503314, title=Creed II, genre_ids=[18,28]}, {overview=Earth is peaceful following the Tournament of Power. Realizing that the universes still hold many more strong people yet to see, Goku spends all his days training to reach even greater heights. Then one day, Goku and Vegeta are faced by a Saiyan called 'Broly' who they've never seen before. The Saiyans were supposed to have been almost completely wiped out in the destruction of Planet Vegeta, so what's this one doing on Earth? This encounter between the three Saiyans who have followed completely different destinies turns into a stupendous battle, with even Frieza (back from Hell) getting caught up in the mix., original_language=ja, original_title=ドラゴンボール超スーパー ブロリー, release_date=2018-12-14},
        {vote_count, id=567604, title=Dragon Ball Super: Broly, genre_ids=[28,16,878]}, {overview=A kidnapped Fred Savage is forced to endure Deadpool's PG-13 rendition of Deadpool 2 as a Princess Bride-esque story that's full of magic, wonder & zero F's., original_language=en, original_title=Once Upon a Deadpool, release_date=2018-12-11},{vote_count, id=324857, title=Once Upon a Deadpool, genre_ids=[35,28]}, {overview=Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \Kingpin\ Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension., original_language=en, original_title=Spider-Man: Into the Spider-Verse, release_date=2018-12-07},{vote_count, id=335983, title=Spider-Man: Into the Spider-Verse, genre_ids=[28,12,16,878,35]}, {overview=Investigative journalist Eddie Brock attempts a comeback following a scandal, but accidentally becomes the host of Venom, a violent, super powerful alien symbiote. Soon, he must rely on his newfound powers to protect the world from a shadowy organization looking for a symbiote of their own., original_language=en, original_title=Venom, release_date=2018-09-28},{vote_count, id=375588, title=Venom, genre_ids=[878,28]}, {overview=A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown., original_language=en, original_title=Robin Hood, release_date=2018-11-20},{vote_count, id=428078, title=Robin Hood, genre_ids=[12,28,53]}, {overview=Set in a world many thousands of years in the future. Earth’s cities now roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive Traction Cities, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the Outlands who will change the course of his life forever., original_language=en, original_title=Mortal Engines, release_date=2018-12-06},
        {vote_count, id=487672, title=Mortal Engines, genre_ids=[878,28,12,14,53]}, {overview=In the wake of The Death of Superman, the world is still mourning the loss of the Man of Steel following his fatal battle with the monster Doomsday. However, no sooner as his body been laid to rest than do four new bearers of the Superman shield come forward to take on the mantle. The Last Son of Krypton, Superboy, Steel, and the Cyborg Superman all attempt to fill the vacuum left by the world's greatest champion. Meanwhile, Superman's death has also signaled to the universe that Earth is vulnerable. Can these new Supermen and the rest of the heroes prove them wrong?, original_language=en, original_title=Reign of the Supermen, release_date=2019-01-13},{vote_count, id=460321, title=Reign of the Supermen, genre_ids=[16,28,878]},
        {overview=A counter-terrorism expert takes a job protecting a young heiress. After an attempted kidnapping puts both of their lives in danger, they must flee., original_language=en, original_title=Close, release_date=2019-01-18},{vote_count, id=461693, title=Close, genre_ids=[28,53]}, {overview=A constable who prefers to mind his own business gets into a situation where he has to hide from a most-wanted gangster., original_language=ta, original_title=சிலுக்குவார்பட்டி சிங்கம், release_date=2018-12-21},{vote_count, id=438799, title=Silukkuvarupatti Singam, genre_ids=[28,35]}, {overview=On the eve of D-Day during World War II, American paratroopers are caught behind enemy lines after their plane crashes on a mission to destroy a German Radio Tower in a small town outside of Normandy. After reaching their target, the paratroopers come to realize that besides fighting off Nazi soldiers, they also must fight against horrifying, bloody, and violent creatures that are a result of a secret Nazi experiment., original_language=en, original_title=Overlord, release_date=2018-10-25},{vote_count, id=522681, title=Overlord, genre_ids=[28,27,878,53,10752]}, {overview=Six strangers find themselves in circumstances beyond their control, and must use their wits to survive., original_language=en, original_title=Escape Room, release_date=2019-01-03},{vote_count, id=450001, title=Escape Room, genre_ids=[27,53,28]}, {overview=After being defeated by Ip Man, Cheung Tin Chi (Zhang) is attempting to keep a low profile. While going about his business, he gets into a fight with a foreigner by the name of Davidson (Bautista), who is a big boss behind the bar district. Tin Chi fights hard with Wing Chun and earns respect., original_language=cn, original_title=葉問外傳：張天志, release_date=2018-10-13},{vote_count, id=446101, title=Master Z: Ip Man Legacy, genre_ids=[28]}, {overview=High school senior Lily and her group of friends live in a haze of texts, posts, selfies and chats just like the rest of the world. So, when an anonymous hacker starts posting details from the private lives of everyone in their small town, the result is absolute madness leaving Lily and her friends questioning whether they'll live through the night., original_language=en, original_title=Assassination Nation, release_date=2018-09-21},{vote_count, id=543103, title=Assassination Nation, genre_ids=[53,35,28,18]}, {overview=In the world of Sougo Tokiwa and Sento Kiryu, their \companions\ are losing their memories one after the other as they're replaced by other people. The Super Time Jacker, Tid , appears before them. He orders his powerful underlings, Another Double and Another Den-O, to pursue a young boy called Shingo. While fighting to protect Shingo, Sougo meets Ataru, a young man who loves Riders, but Ataru says that Kamen Riders aren't real. What is the meaning of those words? While the mystery deepens, the true enemy that Sougo and Sento must defeat appears in the Kuriogatake mountain..., original_language=ja, original_title=仮面ライダー平成ジェネレーションズFOREVER, release_date=2018-12-22}]}, title=Kamen Rider Heisei Generations FOREVER, genre_ids=[28,12,878]}]*/

        System.out.println("Affichage du titre du film qui se trouve a la premieur possition dans la liste par exemple: ");
        System.out.println(liste.get(0).get("original_title"));
        System.out.println(liste.get(0).get("overview"));
        System.out.println(liste.get(0).get("poster_path"));

        System.out.println("Test de la fonction recupererImage");
        System.out.println(RequeteTMDB.recupererImage(liste.get(0)));

        System.out.println("Affichage du titre du film qui se trouve a la premiere possition dans la liste par exemple: ");
        System.out.println(liste.get(0).get("title"));//Affiche : Bumblebee

        //https://api.themoviedb.org/3/genre/movie/list?api_key=c36506bd3193be04b65c8828935dc788

    }
}

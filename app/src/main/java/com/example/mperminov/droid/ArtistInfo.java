package com.example.mperminov.droid;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

public class ArtistInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_info);
        //use HashMap for storing info about bands KEY=band name, VALUE=bio
        HashMap<String, String> artistInfo = new HashMap<>();
        artistInfo.put("Iron Maiden","Iron Maiden was formed on Christmas day in 1975 by Steve Harris, who recruited guitarists Dave Sullivan and Terry Rance, drummer Ron Matthews, and vocalist Paul Day. Day, who lacked stage presence, was quickly replaced by Dennis Wilcock. Rance and Sullivan were dropped when Dave Murray was found, as neither of the former could play lead and the latter clearly could. Bob Angelo came in to complement him, but ended up trying to upstage him continuously, so was fired in late 1976. He joined Praying Mantis.\n" +
                "\n" +
                "Dave Murray left in the spring of 1977 after getting into an argument with Dennis Wilcock and was replaced by Terry Wapram on guitars. Ron Matthews also left, then in came Thunderstick, a.k.a. Barry Graham. Finally, keyboardist Tony Moore was brought in. This line-up lasted one gig before everyone realized that keyboards were a no go. Tony was fired and Terry left out of solidarity. Dave Murray returned and Dennis Wilcock again decided he had enough, but this time he took Thunderstick and left. Dennis formed V1 with Terry and Tony while Thunderstick popped up in Samson a bit later.\n" +
                "\n" +
                "Deciding to continue, Steve and Dave found drummer Doug Sampson and vocalist Paul Di'Anno in mid-1977. This four-piece line-up recorded the first demo, The Soundhouse Tapes, on December 31, 1978. Paul Cairns was brought in on guitars and he lasted for about three months before leaving of his own volition. Paul Todd played two gigs before his girlfriend told him to either choose a tour with Maiden or her. He was in Maiden for precisely two days in September 1979. Tony Parsons came in in early September (the live recording from September 10, 1979 has him on guitars) and lasted until just about the end of the year before leaving due to his unhappiness at being surrounded by far more talented musicians. He was replaced by Dennis Stratton. In January 1980, Doug Sampson fell ill and quit after a tour. Clive Burr arrived and the first album was recorded.\n" +
                "\n" +
                "Dennis Stratton went to Lionheart in October of 1980, citing a love of classic rock as opposed to metal and was replaced by Adrian Smith (Urchin) in September 1980. Paul Di'Anno had constant drinking problems and was once arrested before a show, forcing Steve Harris to take over on vocals (February 8, 1980), and thus he was replaced by Bruce Bruce of Samson, who reverted to his non-repetitive almost birth name of Bruce Dickinson (his full name is Paul Bruce Dickinson, but the band had had enough of singers named Paul!). Bruce's first gig was October 25, 1981 in Italy. \n" +
                "\n" +
                "Burr left the band at the end of 1982 on good terms since he wanted a break from the music business and all the touring. He would crop up in various projects over the years. In came Nicko McBrain, formerly of Trust. This line-up lasted until January 1990 when Adrian Smith left and was replaced by Janick Gers.\n" +
                "\n" +
                "Bruce Dickinson left the band in 1993, wishing to concentrate on his solo career. Blaze Bayley (real name: Bayley Cook - Blaze was a school nickname) from Wolfsbane took over on vocals for two albums. Then both Bruce Dickinson and Adrian Smith returned in 1999 and toured for a video game, Ed Hunter. The tour was monstrously successful and the band put out a new album, Brave New World and a new live album as well, Rock in Rio. Blaze went to form his solo project, Blaze.\n" +
                "\n" +
                "Former drummer Clive Burr was diagnosed with multiple sclerosis in 2002, so the band held a benefit for him and released a single, Run To The Hills, featuring live tracks from 1982 with Clive on drums.\n" +
                "\n" +
                "Michael Kenney (not to be confused with Mick Kenney of Anaal Nathrakh) plays keyboards for Iron Maiden on tour (and contributes some studio work too).\n" +
                "\n" +
                "Trivia: Iron Maiden were the first heavy metal band to ever be featured on MTV during its first day, August 1, 1981. \"Iron Maiden\" was music video number 16 and \"Wrathchild\" was number 33 out of the first 62 videos.\n" +
                "\n" +
                "Iron Maiden is also known for their mascot, Eddie. Eddie's full name is Eddie The Head - or Edward The Head - and it comes from the following old joke: \n" +
                "Eddie was born with no body and no arms and no legs. Just a head. But despite this slight birth defect his parents loved him very much. So on his sixteenth birthday they run into a doctor that says \"Hey, I can give Eddie a body\"... so the parents are going totally nuts because finally their kid can have a body and be like other normal people. They go home and are really excited and say \"Have we got a surprise for you. It's the best present ever!\" and Eddie says \"Oh, no, not another fucking hat!\" ");
        //use HashMap for storing photo of band KEY=band name, VALUE=drawable with picture of the band
        HashMap<String, Drawable> artistPhoto = new HashMap<>();
        artistPhoto.put("Iron Maiden", getDrawable(R.drawable.ironmaiden));
        Intent incomingIntent = getIntent();
        //get info from incoming intent from now_playing activity and set appropriate values to views
        TextView bioArtist = findViewById(R.id.bio);
        TextView tvArtist = findViewById(R.id.tv_artist_info);
        ImageView ivArtist = findViewById(R.id.iv_artist_photo);
        String artist = incomingIntent.getStringExtra("artist");
        bioArtist.setText(artistInfo.get(artist));
        ivArtist.setImageDrawable(artistPhoto.get(artist));
        tvArtist.setText(artist);
    }
}

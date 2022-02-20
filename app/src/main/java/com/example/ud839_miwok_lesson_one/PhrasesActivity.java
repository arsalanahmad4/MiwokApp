package com.example.ud839_miwok_lesson_one;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed
     * playing the audio file.
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        final ArrayList<Word> phrases= new ArrayList<>();

        //words.add("zero");
        phrases.add(new Word("Where are you going?","minto wuksus",R.raw.phrase_where_are_you_going));
        phrases.add(new Word("What is your name?","tinnә oyaase'nә",R.raw.phrase_what_is_your_name));
        phrases.add(new Word("My name is...","oyaaset...",R.raw.phrase_my_name_is));
        phrases.add(new Word("How are you feeling?","michәksәs?",R.raw.phrase_how_are_you_feeling));
        phrases.add(new Word("I’m feeling good.","kuchi achit",R.raw.phrase_im_feeling_good));
        phrases.add(new Word("Are you coming?","әәnәs'aa?",R.raw.phrase_are_you_coming));
        phrases.add(new Word("Yes, I’m coming.","hәә’ әәnәm",R.raw.phrase_yes_im_coming));
        phrases.add(new Word("I’m coming.","әәnәm",R.raw.phrase_im_coming));
        phrases.add(new Word("Let’s go.","yoowutis",R.raw.phrase_lets_go));
        phrases.add(new Word("Come here.","әnni'nem",R.raw.phrase_come_here));


        WordAdapter itemsAdapter = new WordAdapter(this, phrases,R.color.category_phrases);
        ListView listView = (ListView) findViewById(R.id.phrases_list);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = phrases.get(position);
                // Release the media player if it currently exists because we are about to
                // play a different sound file
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this,word.getAudioResourceId());
                mMediaPlayer.start();
                // Setup a listener on the media player, so that we can stop and release the
                // media player once the sound has finished playing.
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }
    //Stopping the media player as soon as the user switches from our current activity to manage resources
    @Override
    protected void onStop() {
        super.onStop();
        //When the activity is stopped, release the media player resources because we
        //won't be playing any more sounds
        releaseMediaPlayer();
    }
    /**
     * Clean up the mediaPlayer by releasing its resources
     */
    private void releaseMediaPlayer(){
        //If mediaPlayer is not null it may be currently playing a sound
        if(mMediaPlayer!=null){
            //regardless of the current state of media player release its resources
            //because we no longer need it.
            mMediaPlayer.release();

            //Set the media player back to null. For our code,we've decided that
            //setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment
            mMediaPlayer=null;
        }
    }
}
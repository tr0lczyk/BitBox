package com.olczyk.android.beatbox;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class SoundViewModelTest {
    private BeatBox beatBox;
    private Sound sound;
    private SoundViewModel subject;

    @Before
    public void setUp() throws Exception {
        beatBox = mock(BeatBox.class);
        sound = new Sound("assetPath");
        subject = new SoundViewModel(beatBox);
        subject.setSound(sound);
    }

    @Test
    public void exposeSoundNameAsTitle(){
        assertThat(subject.getTitle(),is(sound.getName()));
    }
}
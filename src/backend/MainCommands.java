package backend;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org_jmusixmatch.config.Constants;
import org_jmusixmatch.entity.artist.Artist;
import org_jmusixmatch.entity.artist.ArtistData;
import org_jmusixmatch.entity.artist.get.ArtistGetMessage;
import org_jmusixmatch.entity.artist.getList.ArtistListGetMessage;
import org_jmusixmatch.entity.artist.getList.ArtistWrapper;
import org_jmusixmatch.entity.lyrics.Lyrics;
import org_jmusixmatch.entity.lyrics.get.LyricsGetMessage;
import org_jmusixmatch.entity.track.Track;
import org_jmusixmatch.entity.track.TrackData;
import org_jmusixmatch.entity.track.get.TrackGetMessage;
import org_jmusixmatch.entity.track.getList.TrackListGetMessage;
import org_jmusixmatch.entity.track.getList.TrackWrapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MainCommands {

    public Track findMatches(String artist, String title) {
        Track track = new Track();
        String response = recieveMessage(artist, title);
        System.out.println(response);
        track = getMatchingTrack(response);
        return track;
    }

    public Artist findArtist(Integer artistId) {
        Artist artist = new Artist();
        String response = recieveMessageArtistId(artistId);
        System.out.println(response);
        artist = getMatchingArtist(response);
        return artist;
    }

    public Lyrics findLyrics(Integer trackId) {
        Lyrics lyrics = new Lyrics();
        String response = recieveMessageLyricsTrackId(trackId);
        System.out.println(response);
        lyrics = getMatchingLyrics(response);
        return lyrics;
    }

    public List<Artist> findChartArtists() {
        List<Artist> artists;
        String response = receiveMessageArtistList();
        System.out.println(response);
        artists = getChartArtist(response);
        for(Artist artist : artists){
            System.out.println(artist.getArtistData().getArtistName());
        }
        return artists;
    }

    public List<Track> findChartTracks() {
        List<Track> tracks;
        String response = receiveMessageTrackList();
        System.out.println(response);
        tracks = getChartTrack(response);
        for(Track track : tracks){
            System.out.println(track.getTrack().getTrackName());
        }
        return tracks;
    }

    private List<Track> getChartTrack(String response) {
        List<TrackWrapper> trackWrappers = new ArrayList<>();
        TrackListGetMessage message = null;
        Gson gson = new Gson();
        try{
            message = gson.fromJson(response, TrackListGetMessage.class);
        }catch (JsonSyntaxException jpe){
        }

        trackWrappers = message.getTrackListMessage().getBody().getTrackList();

        List<Track> tracks = new ArrayList<>();
        for (TrackWrapper trackWrapper: trackWrappers) {
            TrackData trackData = trackWrapper.getTrackData();
            Track track = new Track();
            track.setTrack(trackData);
            tracks.add(track);
        }

        return tracks;
    }


    private List<Artist> getChartArtist(String response) {
        List<ArtistWrapper> artistWrappers = new ArrayList<>();
        ArtistListGetMessage message = null;
        Gson gson = new Gson();
        try{
            message = gson.fromJson(response, ArtistListGetMessage.class);
        }catch (JsonSyntaxException jpe){
        }

        artistWrappers = message.getArtistListMessage().getBody().getArtistList();

        List<Artist> artists = new ArrayList<>();
        for (ArtistWrapper artistWrapper : artistWrappers) {
            ArtistData artistData = artistWrapper.getArtist();
            Artist artist = new Artist();
            artist.setArtistData(artistData);
            artists.add(artist);
        }

        return artists;
    }


    private Lyrics getMatchingLyrics(String response) {
        LyricsGetMessage message = null;
        Gson gson = new Gson();

        try{
            message = gson.fromJson(response, LyricsGetMessage.class);
        }catch (JsonSyntaxException jpe){
        }

        return message.getContainer().getBody().getLyrics();
    }


    public Track getMatchingTrack(String response) {
        Track track = new Track();
        TrackGetMessage message = null;
        Gson gson = new Gson();

        try{
            message = gson.fromJson(response, TrackGetMessage.class);
        }catch (JsonSyntaxException jpe){
        }

        TrackData trackData = message.getTrackMessage().getBody().getTrack();
        track.setTrack(trackData);

        return track;
    }

    private static Artist getMatchingArtist(String response) {
        Artist artist = new Artist();
        ArtistGetMessage message = null;
        Gson gson = new Gson();

        try{
            message = gson.fromJson(response, ArtistGetMessage.class);
        }catch (JsonSyntaxException jpe){
        }
        System.out.println("" + message);

        ArtistData artistData = message.getArtistMessage().getBody().getArtist();
        artist.setArtistData(artistData);

        return artist;
    }

    public String recieveMessage(String artist, String title) {
        return sendRequest("matcher.track.get?q_track=" + URLEncoder.encode(title) + "&q_artist=" + URLEncoder.encode(artist) + "&apikey=" + Constants.API_MY);
    }
    private static String recieveMessageArtistId(Integer artistId) {
        return sendRequest("artist.get?artist_id=" + artistId + "&apikey=" + Constants.API_MY);
    }
    private String recieveMessageLyricsTrackId(Integer trackId) {
        return sendRequest("track.lyrics.get?track_id=" + trackId + "&apikey=" + Constants.API_MY);
    }

    private String receiveMessageArtistList() {
        return sendRequest("chart.artists.get?chart_name=top&page=1&page_size=3&apikey="+ Constants.API_MY);
    }
    private String receiveMessageTrackList() {
        return sendRequest("chart.tracks.get?chart_name=top&page=1&page_size=3&apikey="+ Constants.API_MY);
    }

    public static String sendRequest(String requestString) {
        StringBuffer buffer = new StringBuffer();

        try {

            String apiUrl = Constants.API_URL + Constants.API_VERSION
                    + Constants.URL_DELIM + requestString;

            URL url = new URL(apiUrl);

            BufferedReader in = new BufferedReader(new InputStreamReader(
                    url.openStream(), StandardCharsets.UTF_8));
            String str;

            while ((str = in.readLine()) != null) {
                buffer.append(str);
            }

            in.close();
        } catch (MalformedURLException e) {

        } catch (IOException e) {

        }

        return buffer.toString();
    }








}

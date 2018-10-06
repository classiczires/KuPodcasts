package ke.topcast.data.model;

import java.util.HashMap;
import java.util.List;

import ke.topcast.data.network.Api;
import ke.topcast.activities.MainActivity;
import ke.topcast.data.network.NetworkRequest;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class NewPodcasts implements PodcastOps {
    private List<Podcast> podcastList;

    @Override
    public void setPodcasts(List<Podcast> podcasts) {
        this.podcastList = podcasts;
    }

    @Override
    public void getPodcasts(int limitFrom, int limitTo) {
        HashMap<String, String> params = new HashMap<>();
        params.put("limitFrom", String.valueOf(limitFrom));
        params.put("limitTo", String.valueOf(limitTo));
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("limitFrom", params.get("limitFrom"))
                .addFormDataPart("limitTo", params.get("limitTo"))
                .build();

        NetworkRequest request =
                request = new NetworkRequest(Api.URL_GET_NEW_PODCASTS, requestBody);

        request.execute();
    }

    @Override
    public Podcast getPodcast(int position) {
        return podcastList.get(position);
    }
}

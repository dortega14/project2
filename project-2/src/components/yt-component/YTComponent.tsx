import React from 'react';
import YouTube from 'react-youtube';
import { IYoutube } from '../../model/IYoutube';

export interface IYoutuber {
    youtubeLinks: IYoutube;
}

export class YTComponent extends React.PureComponent<IYoutuber> {
    render() {
        const opts = {
            height: '390',
            width: '640',
            playerVars: { // https://developers.google.com/youtube/player_parameters
              start: this.props.youtubeLinks.time
            }
          };
        return (
            <>
                <YouTube 
                    videoId={this.props.youtubeLinks.ytlink}
                    opts={opts}
                />
            </>
        )
    }
}

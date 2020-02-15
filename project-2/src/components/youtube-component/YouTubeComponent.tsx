import React from 'react';
import YouTube from 'react-youtube';
import { IYoutube } from '../../model/IYoutube';

export interface IYoutuber {
    youtubeLinks: IYoutube;
}

export class YTComponent extends React.PureComponent<IYoutube> {
    render() {
        const opts = {
            height: '390',
            width: '640',
            playerVars: { // https://developers.google.com/youtube/player_parameters
              start: this.props.time
            }
          };
        return (
            <>
                <YouTube 
                    videoId={this.props.ytlink}
                    opts={opts}
                />
            </>
        )
    }
}

export default YTComponent;
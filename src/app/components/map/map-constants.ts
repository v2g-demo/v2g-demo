import {MarkerInterface} from '../../interfaces/marker.interface';

export class MapConstants {

  public static get MARKERS_MOCK(): MarkerInterface[] {
    return [
      // These are all just random coordinates from https://www.random.org/geographic-coordinates/
      {
        lat: 22.33159,
        lng: 105.63233,
        alpha: 1,
        icon: {
          path: this.MARKERS_ICONS.car,
          rotation: 90,
          fillColor: 'black',
          strokeColor: 'black',
          fillOpacity: 1,
          strokeOpacity: 1,
          scale: 1,
          strokeWeight: 1,
          anchor: {
            x: 22,
            y: 22
          }
        },
      },
      {
        lat: 7.92658,
        lng: -12.05228,
        alpha: 1,
        icon: {
          path: this.MARKERS_ICONS.car,
          rotation: 45,
          fillColor: 'black',
          strokeColor: 'black',
          fillOpacity: 1,
          strokeOpacity: 1,
          scale: 1,
          strokeWeight: 1,
          anchor: {
            x: 22,
            y: 22
          }
        },
      },
      {
        lat: 48.75606,
        lng: -118.859,
        alpha: 1,
        icon: {
          path: this.MARKERS_ICONS.car,
          rotation: 180,
          fillColor: 'black',
          strokeColor: 'black',
          fillOpacity: 1,
          strokeOpacity: 1,
          scale: 1,
          strokeWeight: 1,
          anchor: {
            x: 22,
            y: 22
          }
        },
      },
      {
        lat: 5.19334,
        lng: -67.03352,
        alpha: 1,
        icon: {
          path: this.MARKERS_ICONS.car,
          rotation: 360,
          fillColor: 'black',
          strokeColor: 'black',
          fillOpacity: 1,
          strokeOpacity: 1,
          scale: 1,
          strokeWeight: 1,
          anchor: {
            x: 22,
            y: 22
          }
        },
      },
      {
        lat: 12.09407,
        lng: 26.31618,
        alpha: 1,
        icon: {
          path: this.MARKERS_ICONS.hospital,
          rotation: 0,
          fillColor: 'black',
          strokeColor: 'black',
          fillOpacity: 1,
          strokeOpacity: 1,
          scale: 1,
          strokeWeight: 1,
          anchor: {
            x: 22,
            y: 22
          }
        },
      },
      {
        lat: 47.92393,
        lng: 78.58339,
        alpha: 1,
        icon: {
          path: this.MARKERS_ICONS.hospital,
          rotation: 0,
          fillColor: 'black',
          strokeColor: 'black',
          fillOpacity: 1,
          strokeOpacity: 1,
          scale: 1,
          strokeWeight: 1,
          anchor: {
            x: 22,
            y: 22
          }
        },
      }
    ];
  }

  public static get MARKERS_ICONS() {
    return {
      // tslint:disable-next-line:max-line-length
      car:  'M16.4102.5h-10.75C2.8094.5.5 3.6698.5 6.5196V38.34c0 2.8488 2.3094 5.16 5.1592 5.16h10.75c2.8488 0 5.16-2.3104 5.16-5.16V6.5196C21.5685 3.6698 19.26.5 16.4102.5zm4.256 12.9717v10.665l-2.495.321v-4.394l2.495-6.592zm-1.3093-3.1223L17.328 18.13H4.7404L2.709 10.3494c.001 0 8.1224-2.7592 16.648 0zm-15.43 10.0022v4.107l-2.496-.319V13.7588l2.496 6.5928zm-2.496 14.834v-9.471l2.496.3136v7.4933l-2.496 1.664zm1.4235 2.6916l2.028-3.05h12.5904l2.0288 3.05H2.8542zM18.17 33.2355v-7.1972l2.495-.3245v9.1866l-2.495-1.665z',
      // tslint:disable-next-line:max-line-length
      gasStation: 'M38.4 10.8l-8.9-8.9L27 4.4l5 5.1c-2.2.8-3.8 3-3.8 5.5 0 3.3 2.6 6 5.9 6 .9 0 1.7-.2 2.4-.5v17.2c0 1.3-1 2.4-2.4 2.4-1.3 0-2.3-1.1-2.3-2.4V27c0-2.7-2.2-4.8-4.8-4.8h-2.4V5.5c0-2.7-2.1-4.8-4.8-4.8H5.5C2.8.7.7 2.8.7 5.5v38.2h23.9V25.8h3.6v11.9c0 3.3 2.6 6 5.9 6a6 6 0 0 0 6-6V15c0-1.6-.7-3.1-1.7-4.2zm-18.6 6.6H5.5V5.5h14.3v11.9zm14.3 0c-1.3 0-2.3-1.1-2.3-2.4s1-2.4 2.3-2.4c1.4 0 2.4 1.1 2.4 2.4s-1 2.4-2.4 2.4z',
      // tslint:disable-next-line:max-line-length
      hospital: 'M42.070688926618 27.589580267608c.051101943047-.15284216423.0801123932-.316719534122.0801123932-.487048741316V9.214874070422c0-.847953878123-.68777244668-1.535252792846-1.535727533805-1.535252792846h-8.547230214385v19.03944212019c0 .305673791982-.055246293068.597990840763-.152849248208.87051686984h-1.002637683393c.051101943047-.15284216423.0801123932-.316719534122.0801123932-.487048741316V2.535260044063c0-.847958268323-.687767178438-1.535257183046-1.53570821692-1.535257183046h-13.40943082849c-.847958599287 0-1.535253392065.687298914723-1.535253392065 1.535257183046v24.56727148223c0 .170329207194.029010450142.334206577086.080094832384.487048741316h-1.002160029492c-.09760295514-.272526029078-.152831687402-.56484307786-.152831687402-.87051686984V7.679621277576H5.09477872835c-.847958599286 0-1.535253392064.687298914723-1.535253392064 1.535252792846v17.88765745587c0 .170329207194.029010450142.334206577086.07963825145.487048741316H1.000002861017v3.17362259341h43.505v-3.17362259341h-2.4343139344zm-33.90540341414-6.27083464118H5.964372239607V19.11829506158H8.16528551248v2.200450564847zm0-3.863677675426H5.964372239607v-2.200917682083H8.16528551248V17.455067951zm0-3.73617047493H5.964372239607V11.51798506223H8.16528551248v2.200912413843zm3.42957256746 7.599848150355H9.393944807066V19.11829506158h2.200913272873v2.200450564847zm0-3.863677675426H9.393944807066v-2.200917682083h2.200913272873V17.455067951zm0-3.73617047493H9.393944807066V11.51798506223h2.200913272873v2.200912413843zM26.168956628973 27.48691984065h-6.461867039537v-8.0615742205h6.461867039537v8.0615742205zM22.7522736925 12.515557820052c-2.989024648137 0-5.412292836084-2.42326372997-5.412292836084-5.412286333433S19.763705625307 1.69052418223 22.7522736925 1.69052418223s5.412749417018 2.42325846173 5.412749417018 5.412747304388-2.423268187947 5.412286333433-5.412749417018 5.412286333433zm13.972885067123 8.803187806375h-2.200453179777V19.11829506158h2.200453179777v2.200450564847zm0-3.863677675426h-2.200453179777v-2.200917682083h2.200453179777V17.455067951zm0-3.73617047493h-2.200453179777V11.51798506223h2.200453179777v2.200912413843zm3.429119498686 7.599848150355h-2.2004602041V19.11829506158h2.2004602041v2.200450564847zm0-3.863677675426h-2.2004602041v-2.200917682083h2.2004602041V17.455067951zm0-3.73617047493h-2.2004602041V11.51798506223h2.2004602041v2.200912413843zM24.095552362446 5.759980170374h2.072947685593v2.68657824229h-2.072947685593v2.073855647822h-2.686574900678V8.446558412665H19.33604733698v-2.68657824229h2.072930124788v-2.07293809611h2.686574900678v2.07293809611z',
    };
  }
}

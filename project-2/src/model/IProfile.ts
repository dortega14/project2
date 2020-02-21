import IUser from "./IUser";

export interface IProfile {
    profileId: number;
    bio: string;
    coverImage?: any;
    profileUser: IUser;
}
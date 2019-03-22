
export class SignUpInfo{

    lastName: string;
    firstName: string;
    username: string;
    email: string;
    phone: string;
    password: string;
    role: string[];

    constructor( lastName: string,firstName: string, username: string, email: string, phone: string, password: string){
        this.lastName = lastName;
        this.firstName = firstName;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this. password = password;
        this.role=['user'];
    }
}
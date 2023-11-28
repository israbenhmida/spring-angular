import { Reservation } from "./reservation";

    export class Chambre {
      idChambre: number;
      typeC: string;
      numeroChambre: number;
      reservation: Reservation | null;// You need to define the Agence model if not already done
  }
  
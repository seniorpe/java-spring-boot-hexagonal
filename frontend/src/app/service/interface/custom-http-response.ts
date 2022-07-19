export interface CustomHttpResponse<T>{
    httpStatus: string;
    httpStatusCode: number;
    reason: string;
    content: T;
    timestamp: string;
  }

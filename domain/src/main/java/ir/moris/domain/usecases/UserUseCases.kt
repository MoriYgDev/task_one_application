package ir.moris.domain.usecases

data class UserUseCases (
    val insertUserUseCase: InsertUserUseCase ,
    val getAllUsersUseCase: GetAllUsersUseCase
        ){
}
package org.sackfix.fix50sp2modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.modified.xml
  */
case class RequestForPositionsMessage(posReqIDField:PosReqIDField,
                                      posReqTypeField:PosReqTypeField,
                                      matchStatusField:Option[MatchStatusField]=None,
                                      subscriptionRequestTypeField:Option[SubscriptionRequestTypeField]=None,
                                      settlCurrencyField:Option[SettlCurrencyField]=None,
                                      partiesComponent:PartiesComponent,
                                      accountField:Option[AccountField]=None,
                                      acctIDSourceField:Option[AcctIDSourceField]=None,
                                      accountTypeField:Option[AccountTypeField]=None,
                                      instrumentComponent:Option[InstrumentComponent]=None,
                                      currencyField:Option[CurrencyField]=None,
                                      instrmtLegGrpComponent:Option[InstrmtLegGrpComponent]=None,
                                      undInstrmtGrpComponent:Option[UndInstrmtGrpComponent]=None,
                                      clearingBusinessDateField:ClearingBusinessDateField,
                                      settlSessIDField:Option[SettlSessIDField]=None,
                                      settlSessSubIDField:Option[SettlSessSubIDField]=None,
                                      trdgSesGrpComponent:Option[TrdgSesGrpComponent]=None,
                                      transactTimeField:TransactTimeField,
                                      responseTransportTypeField:Option[ResponseTransportTypeField]=None,
                                      responseDestinationField:Option[ResponseDestinationField]=None,
                                      textField:Option[TextField]=None,
                                      encodedTextLenField:Option[EncodedTextLenField]=None,
                                      encodedTextField:Option[EncodedTextField]=None) extends SfFixMessageBody("AN")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,posReqIDField)
    fmt(b,posReqTypeField)
    matchStatusField.foreach(fmt(b,_))
    subscriptionRequestTypeField.foreach(fmt(b,_))
    settlCurrencyField.foreach(fmt(b,_))
    fmt(b,partiesComponent)
    accountField.foreach(fmt(b,_))
    acctIDSourceField.foreach(fmt(b,_))
    accountTypeField.foreach(fmt(b,_))
    instrumentComponent.foreach(fmt(b,_))
    currencyField.foreach(fmt(b,_))
    instrmtLegGrpComponent.foreach(fmt(b,_))
    undInstrmtGrpComponent.foreach(fmt(b,_))
    fmt(b,clearingBusinessDateField)
    settlSessIDField.foreach(fmt(b,_))
    settlSessSubIDField.foreach(fmt(b,_))
    trdgSesGrpComponent.foreach(fmt(b,_))
    fmt(b,transactTimeField)
    responseTransportTypeField.foreach(fmt(b,_))
    responseDestinationField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    b
  }

}
     
object RequestForPositionsMessage extends SfFixMessageDecoder {
  val MsgType="AN"
  val MsgName="RequestForPositions"
             
  override val MandatoryFields = HashSet[Int](
    PosReqIDField.TagId, PosReqTypeField.TagId, ClearingBusinessDateField.TagId, TransactTimeField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    PartiesComponent.isMandatoryField(tagId) || InstrumentComponent.isMandatoryField(tagId) || InstrmtLegGrpComponent.isMandatoryField(tagId) || UndInstrmtGrpComponent.isMandatoryField(tagId) || 
    TrdgSesGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    MatchStatusField.TagId, SubscriptionRequestTypeField.TagId, SettlCurrencyField.TagId, AccountField.TagId, AcctIDSourceField.TagId, 
    AccountTypeField.TagId, CurrencyField.TagId, SettlSessIDField.TagId, SettlSessSubIDField.TagId, ResponseTransportTypeField.TagId, 
    ResponseDestinationField.TagId, TextField.TagId, EncodedTextLenField.TagId, EncodedTextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    PartiesComponent.isOptionalField(tagId) || InstrumentComponent.isOptionalField(tagId) || InstrmtLegGrpComponent.isOptionalField(tagId) || UndInstrmtGrpComponent.isOptionalField(tagId) || 
    TrdgSesGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    PartiesComponent.isFieldOf(tagId) || InstrumentComponent.isFieldOf(tagId) || InstrmtLegGrpComponent.isFieldOf(tagId) || 
    UndInstrmtGrpComponent.isFieldOf(tagId) || TrdgSesGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==PosReqIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(RequestForPositionsMessage(PosReqIDField.decode(myFields.get(PosReqIDField.TagId)).get,
        PosReqTypeField.decode(myFields.get(PosReqTypeField.TagId)).get,
        myFields.get(MatchStatusField.TagId).flatMap(f=>MatchStatusField.decode(f)),
        myFields.get(SubscriptionRequestTypeField.TagId).flatMap(f=>SubscriptionRequestTypeField.decode(f)),
        myFields.get(SettlCurrencyField.TagId).flatMap(f=>SettlCurrencyField.decode(f)),
        PartiesComponent.decode(flds, startPos).get,
        myFields.get(AccountField.TagId).flatMap(f=>AccountField.decode(f)),
        myFields.get(AcctIDSourceField.TagId).flatMap(f=>AcctIDSourceField.decode(f)),
        myFields.get(AccountTypeField.TagId).flatMap(f=>AccountTypeField.decode(f)),
        InstrumentComponent.decode(flds, startPos),
        myFields.get(CurrencyField.TagId).flatMap(f=>CurrencyField.decode(f)),
        InstrmtLegGrpComponent.decode(flds, startPos),
        UndInstrmtGrpComponent.decode(flds, startPos),
        ClearingBusinessDateField.decode(myFields.get(ClearingBusinessDateField.TagId)).get,
        myFields.get(SettlSessIDField.TagId).flatMap(f=>SettlSessIDField.decode(f)),
        myFields.get(SettlSessSubIDField.TagId).flatMap(f=>SettlSessSubIDField.decode(f)),
        TrdgSesGrpComponent.decode(flds, startPos),
        TransactTimeField.decode(myFields.get(TransactTimeField.TagId)).get,
        myFields.get(ResponseTransportTypeField.TagId).flatMap(f=>ResponseTransportTypeField.decode(f)),
        myFields.get(ResponseDestinationField.TagId).flatMap(f=>ResponseDestinationField.decode(f)),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f))))
    } else None
  }

    
}
     
package org.sackfix.fix43

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX43.xml
  */
case class SecurityDefinitionMessage(securityReqIDField:SecurityReqIDField,
                                     securityResponseIDField:SecurityResponseIDField,
                                     securityResponseTypeField:SecurityResponseTypeField,
                                     instrumentComponent:Option[InstrumentComponent]=None,
                                     currencyField:Option[CurrencyField]=None,
                                     tradingSessionIDField:Option[TradingSessionIDField]=None,
                                     tradingSessionSubIDField:Option[TradingSessionSubIDField]=None,
                                     textField:Option[TextField]=None,
                                     encodedTextLenField:Option[EncodedTextLenField]=None,
                                     encodedTextField:Option[EncodedTextField]=None,
                                     noLegsField:Option[NoLegsField]=None,
                                     legsGroups: Option[List[LegsGroup]]=None,
                                     roundLotField:Option[RoundLotField]=None,
                                     minTradeVolField:Option[MinTradeVolField]=None) extends SfFixMessageBody("d")  with SfFixRenderable with SfFixFieldsToAscii {
  if (noLegsField.map(_.value).getOrElse(0) != legsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoLegsField.TagId,noLegsField.map(_.value).getOrElse(0), legsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,securityReqIDField)
    fmt(b,securityResponseIDField)
    fmt(b,securityResponseTypeField)
    instrumentComponent.foreach(fmt(b,_))
    currencyField.foreach(fmt(b,_))
    tradingSessionIDField.foreach(fmt(b,_))
    tradingSessionSubIDField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    noLegsField.foreach(fmt(b,_))
    legsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    roundLotField.foreach(fmt(b,_))
    minTradeVolField.foreach(fmt(b,_))
    b
  }

}
     
object SecurityDefinitionMessage extends SfFixMessageDecoder {
  val MsgType="d"
  val MsgName="SecurityDefinition"
             
  override val MandatoryFields = HashSet[Int](
    SecurityReqIDField.TagId, SecurityResponseIDField.TagId, SecurityResponseTypeField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    InstrumentComponent.isMandatoryField(tagId) || LegsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    CurrencyField.TagId, TradingSessionIDField.TagId, TradingSessionSubIDField.TagId, TextField.TagId, EncodedTextLenField.TagId, 
    EncodedTextField.TagId, NoLegsField.TagId, RoundLotField.TagId, MinTradeVolField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    InstrumentComponent.isOptionalField(tagId) || LegsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    InstrumentComponent.isFieldOf(tagId) || LegsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoLegsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==SecurityReqIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(SecurityDefinitionMessage(SecurityReqIDField.decode(myFields.get(SecurityReqIDField.TagId)).get,
        SecurityResponseIDField.decode(myFields.get(SecurityResponseIDField.TagId)).get,
        SecurityResponseTypeField.decode(myFields.get(SecurityResponseTypeField.TagId)).get,
        InstrumentComponent.decode(flds, startPos),
        myFields.get(CurrencyField.TagId).flatMap(f=>CurrencyField.decode(f)),
        myFields.get(TradingSessionIDField.TagId).flatMap(f=>TradingSessionIDField.decode(f)),
        myFields.get(TradingSessionSubIDField.TagId).flatMap(f=>TradingSessionSubIDField.decode(f)),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f)),
        myFields.get(NoLegsField.TagId).flatMap(f=>NoLegsField.decode(f)),
        if (nextTagPosLookup.contains(NoLegsField.TagId)) LegsGroup.decode(flds, nextTagPosLookup(NoLegsField.TagId)) else None,
        myFields.get(RoundLotField.TagId).flatMap(f=>RoundLotField.decode(f)),
        myFields.get(MinTradeVolField.TagId).flatMap(f=>MinTradeVolField.decode(f))))
    } else None
  }

    
}
     
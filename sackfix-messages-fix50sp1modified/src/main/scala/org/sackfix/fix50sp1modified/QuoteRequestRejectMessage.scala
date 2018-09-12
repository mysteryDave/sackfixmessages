package org.sackfix.fix50sp1modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.modified.xml
  */
case class QuoteRequestRejectMessage(quoteReqIDField:QuoteReqIDField,
                                     rFQReqIDField:Option[RFQReqIDField]=None,
                                     quoteRequestRejectReasonField:QuoteRequestRejectReasonField,
                                     privateQuoteField:Option[PrivateQuoteField]=None,
                                     respondentTypeField:Option[RespondentTypeField]=None,
                                     preTradeAnonymityField:Option[PreTradeAnonymityField]=None,
                                     rootPartiesComponent:Option[RootPartiesComponent]=None,
                                     quotReqRjctGrpComponent:QuotReqRjctGrpComponent,
                                     textField:Option[TextField]=None,
                                     encodedTextLenField:Option[EncodedTextLenField]=None,
                                     encodedTextField:Option[EncodedTextField]=None) extends SfFixMessageBody("AG")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,quoteReqIDField)
    rFQReqIDField.foreach(fmt(b,_))
    fmt(b,quoteRequestRejectReasonField)
    privateQuoteField.foreach(fmt(b,_))
    respondentTypeField.foreach(fmt(b,_))
    preTradeAnonymityField.foreach(fmt(b,_))
    rootPartiesComponent.foreach(fmt(b,_))
    fmt(b,quotReqRjctGrpComponent)
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    b
  }

}
     
object QuoteRequestRejectMessage extends SfFixMessageDecoder {
  val MsgType="AG"
  val MsgName="QuoteRequestReject"
             
  override val MandatoryFields = HashSet[Int](
    QuoteReqIDField.TagId, QuoteRequestRejectReasonField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    RootPartiesComponent.isMandatoryField(tagId) || QuotReqRjctGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    RFQReqIDField.TagId, PrivateQuoteField.TagId, RespondentTypeField.TagId, PreTradeAnonymityField.TagId, TextField.TagId, 
    EncodedTextLenField.TagId, EncodedTextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    RootPartiesComponent.isOptionalField(tagId) || QuotReqRjctGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    RootPartiesComponent.isFieldOf(tagId) || QuotReqRjctGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==QuoteReqIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(QuoteRequestRejectMessage(QuoteReqIDField.decode(myFields.get(QuoteReqIDField.TagId)).get,
        myFields.get(RFQReqIDField.TagId).flatMap(f=>RFQReqIDField.decode(f)),
        QuoteRequestRejectReasonField.decode(myFields.get(QuoteRequestRejectReasonField.TagId)).get,
        myFields.get(PrivateQuoteField.TagId).flatMap(f=>PrivateQuoteField.decode(f)),
        myFields.get(RespondentTypeField.TagId).flatMap(f=>RespondentTypeField.decode(f)),
        myFields.get(PreTradeAnonymityField.TagId).flatMap(f=>PreTradeAnonymityField.decode(f)),
        RootPartiesComponent.decode(flds, startPos),
        QuotReqRjctGrpComponent.decode(flds, startPos).get,
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f))))
    } else None
  }

    
}
     